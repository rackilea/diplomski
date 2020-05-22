<cob:cobertura-instrument datafile="${todir}/${instrument.ser.filename}" >
    <includeClasses regex="com.mycompany.*" />

    <instrumentationClasspath>
      <pathelement path="${war.file}"/>
    </instrumentationClasspath>
  </cob:cobertura-instrument>