function findJar {

  basedir=$1
  searchString=$2

  find $basedir -type f | egrep "(\.jar|\.war|\.ear)$" | while read jarFile; do

    jar tf $jarFile | grep $searchString > /tmp/findJar.tmp

    if [[ $? -eq 0 ]]; then

      echo " *** $jarFile"
      cat /tmp/findJar.tmp
    fi
  done

  rm /tmp/findJar.tmp 2> /dev/null
}