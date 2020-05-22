<commandlineArgs>
                --inference \
                --ontology \
                -i ${basedir}/src/main/resources/ontology/ont-file.owl \
                -o "${basedir}/src/main/java/" \
                --package ${mainPackage}.domain.ontology \
                -n Vocabulary
       </commandlineArgs>