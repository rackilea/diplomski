#!/bin/sh
find . -type f | while read filename
do

  # skip the file if it is already decoded
  if [ "${filename%.dec}" != "${filename}" -o -z "${filename}" ]
  then
    continue
  fi

  (
    # read the file, line by line
    cat "${filename}" | while read line
    do
      line=$(
        echo "${line}"                   |
        sed -e "s/[[:space:]]\{1,\}/;/g" | # split the line by spaces
        tr '[:lower:]' '[:upper:]')        # convert lower to uppercase

       echo "ibase=16; ${line}"          | # format the line for bc
        bc                               | # convert hex to dec
        tr "\n" " "                        # rejoin the output to a line

      echo ""                              # add the new line
    done
  ) > "${filename}.dec"
done