# name: the local Eclipse Folder name I give as script arg
# Create Eclipse .project
projectFile="${name}/.project" ;

# below EOF's content comes from an existing real .project file
echo $( cat <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
  <name>${name}</name>
  <comment></comment>
  <projects></projects>
  <buildSpec></buildSpec>
  <natures></natures>
</projectDescription>
EOF
) > ${projectFile};
echo "✓ ${projectFile} created" ;

# Create Eclipse .classpath if needed (in case of Java project, not needed for default Project)
...