find -iname \*.jar -execdir bash -c "

  unzip -qql {}       | # -l to list zip contents, and -qq to keep quiet.
    sed 's/  */ /g'   | # convert groups of spaces to a single space
    cut -d ' ' -f 5   | # pull out 5th field of each unzip output line
    grep '.class$'    | # each line must end in ".class"
    sed 's/.class$//' | # convert to java class name: remove trailing ".class"
    tr '/' '.'        | # convert to java class name: convert '/' to '.'
    sort              | # sort classnames
  #
  # And, finally, call 'javap' against each class, with most options enabled:
  #
  xargs /opt/java/jdk1.8.0_25/bin/javap -s -p -v -l -c  -cp {}

" \; | gzip > every-jar-decompiled.txt.gz