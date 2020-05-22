<for param="jar">
  <sequential>
    <if>
      <not><equals arg1="@{jar}" arg2="Neo.jar" /></not>
      <then><!-- unzip the jar --></then>
    </if>
  </sequential>
</for>