String[] wepN = new String[100];                        
int wepQty = 0;

for (int i=0; i < wepN.length; i++) {
    if (data.getItems().get(i).getName() == null || "".equals(data.getItems().get(i).getName())) {
        System.out.println(data.getItems().get(i).getName() + " -NO MOARE");
        break;
    }
    wepN[i] = data.getItems().get(i).getName();
    wepQty++;
}