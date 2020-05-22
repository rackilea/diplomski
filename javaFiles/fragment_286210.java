<rich:select id="aluProvs" defaultLabel="Seleccionar provincia" value="#{IngresoAlumno.lugarAlumno.provinciaElegida}" required="true">
    <f:selectItems value="#{IngresoAlumno.lugarAlumno.provincias.entrySet()}" var="prov" itemValue="#{prov.key}" itemLabel="#{prov.value}" />
    <a4j:ajax event="change" render="aluComs" listener="#{IngresoAlumno.lugarAlumno.updateComunas()}" />
    <f:validateRequired />
    <rich:validator />
</rich:select>