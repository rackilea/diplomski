#!/bin/bash

# if missing args, print Usage
##############################
if [[ -z $1 ]] || [[ -z $2 ]]
  then
    echo "Usage : `basename $0` /absolute/path/to/folder1 /absolute/path/to/folder2"

    # exit with failed status
    exit 1
fi

# test if folders exist
#######################
if [[ ! -d $1 ]]
  then
    echo "ERROR : Folder $1 not found..."

    exit 1
fi

if [[ ! -d $2 ]]
  then
    echo "ERROR : Folder $2 not found..."

    exit 1
fi

# get filenames from folder 1
#############################

cd $1

i=0
for f in *.txt
  do
    folder1_files[$i]=$f
    ((i++))
done



# get filenames from folder 2
#############################

cd $2

i=0
for f in *.txt
  do
    folder2_files[$i]=$f
    ((i++))
done


# compare and move duplicates
#############################

for f in ${folder1_files[@]}
  do
    for g in ${folder2_files[@]}
      do
        if [[ $f == $g ]]
          then
            echo "Duplicate file : $g"
            echo "Renaiming to DUPLICATE_$g in $1"
            mv $1/$g $1/DUPLICATE_$g
        fi
    done
done

exit 0