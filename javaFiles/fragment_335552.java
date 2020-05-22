<outofdate>
  <sourcefiles>
    <fileset dir="${definitionFolder}" />
  </sourcefiles>
  <targetfiles>
    <fileset dir="${generatedFolder}" />
  </targetfiles>
  <sequential>
    <exec executable="${codeGenTool-path}">
      <arg value="${definitionFolder}" />
      <arg value="${generatedFolder}" />
    </exec>
  </sequential>
</outofdate>