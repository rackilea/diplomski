<for param="my.directory">
     <fileset dir="${some.directory}"/>
     <sequential>
         <xmlproperty file="@{my.directory}/myxmlpropertyfile.xml"
            prefix="foo-fighters"/>
          <blah, blah, blah/>
          <for param="reset.var">
              <echoproperty prefix=foo-fighters"/>
              <sequential>
                  <var name="@{reset.var}"
                     unset="true"/>
              </sequential>
          </for>
     </sequential>
 </for>