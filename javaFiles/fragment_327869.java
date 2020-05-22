<CT:reportes
        tableHeadder="Reporte Recepcion de Leche"
        fechaValueInicial="#{lecheReporteProveedoresVB.fechaInicial}"
        fechaValueFinal="#{lecheReporteProveedoresVB.fechaFinal}"
        nombreSelectOne="Proveedores: "
        valueSelectOne="#{lecheReporteProveedoresVB.proveedor}"
        valueSelectList="#{CatalogoProveedoresLecheSI.selectList}"
        nombreCommandButton="Consultar"
        funcionCommandButton="#{lecheReporteProveedoresVB.consultar()}"
        tabList="#{bean.tabs}" />