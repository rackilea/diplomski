public class MainActivity extends AppCompatActivity {

    GamesDatabase mGamesDB;
    GamesDao mGamesDao;
    private static final String[] card_suits = new String[]{"Spades","Hearts","Clubs","Diamonds","ooops"};
    private static final String[] courtcard_values = new String[]{
            "Jack","Queen","King","Ace"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGamesDB = Room.databaseBuilder(this,GamesDatabase.class,GamesDatabase.DBNAME)
                .allowMainThreadQueries()
                .build();

        // Suits
        mGamesDao = mGamesDB.getGamesDBDao();
        for (String s: card_suits) {
            mGamesDao.insertCategoriesRow(new Categories(s));
        }

        for (Categories c: mGamesDao.getAllCategoriesRows()) {
            mGamesDao.insertFoldersRow(new Folders(c.getCategoryId(),"CourtCards"));
            mGamesDao.insertFoldersRow(new Folders(c.getCategoryId(),"NormalCards"));
            for (Folders f: mGamesDao.getFoldersPerCategoriesId(c.getCategoryId())) {
                if (f.getFolderName().equals("CourtCards")) {
                    for (String s: courtcard_values) {
                        mGamesDao.insertCardsRow(new Cards(s,getCourtCardValueFromName(s),f.getFolderId()));
                    }
                } else {
                    for (int i=2; i < 11; i++) {
                        mGamesDao.insertCardsRow(new Cards(String.valueOf(i),String.valueOf(i),f.getFolderId()));
                    }
                }
            }
        }

        for (Cards card: mGamesDao.getAllCards()) {
            logCardsInfo(card);
        }

        mGamesDB.close();
    }

    private String getCourtCardValueFromName(String courtCardName) {
        int basevalue = 11;
        for (String s: courtcard_values) {
            if (s.equals(courtCardName)) {
                return String.valueOf(basevalue);
            }
            basevalue++;
            if (basevalue > 13) basevalue = 1;
        }
        return "UNKNOWN";
    }

    private void logCardsInfo(Cards card) {
        Log.d("CARDINFO",
                "Card Name is " + card.getCardName() +
                        "\n\tValue is " + card.getCardValue() +
                        "\n\tCardID is " + card.getCardId() +
                        "\n\tIn Folder " + card.getOwningFolders(mGamesDB).getFolderName() +
                        "\n\t\tIn Category " + card.getOwningCategories(mGamesDB).getCategoryName()
        );
    }
}