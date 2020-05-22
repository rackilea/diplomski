<!-- do some manipulation -->
<pathconvert property="@{backend}.@{for-ie}.target-test-path">
  <path path="@{test-path}"/>
  <chainedmapper>
    <flattenmapper/>
    <globmapper from="*.xml" to="build/@{backend}/@{for-ie}/*.js"/>
  </chainedmapper>
</pathconvert>

<dirname
  property="@{backend}.@{for-ie}.target-test-path-dir"
  file="${@{backend}.@{for-ie}.target-test-path}"
/>

<echo>${@{backend}.@{for-ie}.target-test-path}, ${@{backend}.@{for-ie}.target-test-path-dir}</echo> 

<!-- execute some tasks, call a macro -->

<mkdir dir="${@{backend}.@{for-ie}.target-test-path-dir}"/>

<compile-with-scxml-js-ie
  test-path="@{test-path}"
  backend="@{backend}"
  out-path="${@{backend}.@{for-ie}.target-test-path}"
/>