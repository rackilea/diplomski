public class JListCards {
    private JFrame frame;
    private JPanel radiosPane;
    private JRadioButton[] radios;
    private String[] radiosNames = {"Movie", "Classification", "Price"};
    private JList <Movie> moviesList;
    private ButtonGroup group;

    private Movie[] movies = new Movie[] {
        new Movie("Happy Feet", "AA", 10),
        new Movie("Star Wars", "B12", 15),
        new Movie("Logan", "C", 20)
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JListCards().createAndShowGui());
    }

    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        radiosPane = new JPanel(new GridLayout(1, 3));
        radios = new JRadioButton[3];
        group = new ButtonGroup();

        for (int i = 0; i < radios.length; i++) {
            radios[i] = new JRadioButton(radiosNames[i]);
            radios[i].addActionListener(listener);
            radiosPane.add(radios[i]);
            group.add(radios[i]);
        }

        radios[0].setSelected(true);
        moviesList = new JList<Movie>(movies);
        moviesList.setCellRenderer(new MoviesListCellRenderer(0));

        frame.add(moviesList);
        frame.add(radiosPane, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < radios.length; i++) {
                if (e.getSource().equals(radios[i])) {
                    moviesList.setCellRenderer(new MoviesListCellRenderer(i));
                    break;
                }
            }
        }
    };

    class MoviesListCellRenderer extends DefaultListCellRenderer {
        private int attribute;

        public MoviesListCellRenderer(int attribute) {
            this.attribute = attribute;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Movie) {
                Movie movie = (Movie) value;
                switch (attribute) {
                    case 0:
                        setText(movie.getMovieName());
                        break;
                    case 1:
                        setText(movie.getClassification());
                        break;
                    default:
                        setText(String.valueOf(movie.getPrice()));
                        break;
                }
            }
            return this;
        }
    }

    class Movie {
        private String movieName;
        private String classification;
        private double price;

        public Movie(String movieName, String classification, double price) {
            super();
            this.movieName = movieName;
            this.classification = classification;
            this.price = price;
        }

        public String getMovieName() {
            return movieName;
        }
        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }
        public String getClassification() {
            return classification;
        }
        public void setClassification(String classification) {
            this.classification = classification;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
    }
}