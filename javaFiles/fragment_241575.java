public class PanelGen{
        private static List<PanelGen> panelGenList = new ArrayList<>();
        private Color color;
        public PanelGen(Color c){
            color = c;
            PanelGen.panelGenList.add(this);

        }

        public void setColor(Color c){
            color = c;
        }

        public Color getColor(){
            return color;
        }

        public static void changeColor(Color c){
            for(PanelGen t: panelGenList)
                t.setcolor(c);
        }

        public static void main(String [] args){
            PanelGen a = new PanelGen(Color.red);
            PanelGen b = new PanelGen(Color.blue);
            System.out.println(a.getColor());
            System.out.println(b.getColor());
            PanelGen.changeColor(Color.Orange);
            System.out.println(a.getColor());
            System.out.println(b.getColor());
        }


    }