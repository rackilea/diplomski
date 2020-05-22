...

private List<TabData> tabs = new ArrayList<TabData>();

@PostConstrunct
public void init() {
   tabs.add(new TabData("Recepcion por Dia","../../leche/lecheReporteProveedoresDia.xhtml"));
   ...
}

/* Getter & Setter */