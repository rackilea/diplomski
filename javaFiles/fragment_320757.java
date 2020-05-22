ObservableList<PieChart.Data> pieChartData = FXCollections
                    .observableArrayList(
                            new PieChart.Data("CBO", m.getCBO()),
                            new PieChart.Data("Ce", m.getCe()),
                            new PieChart.Data("DIT", m.getDIT()),
                            new PieChart.Data("LCOM", m.getLCOM()),
                            new PieChart.Data("NOC", m.getNOC()),
                            new PieChart.Data("NPM", m.getNPM()),
                            new PieChart.Data("WMC", m.getWMC()));
            c.setData(pieChartData);