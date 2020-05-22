public class Books extends AppCompatActivity {

    public List<BookModel> books;
    private SharedPreferences mSharedPreferences;
    private static final String SHARED_PREFERENCES = "SharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        ListView booksListView = (ListView)findViewById(R.id.booksListView);

        books = createBooks();


        final BookAdapter adapter = new BookAdapter(this, books);

        booksListView.setAdapter(adapter);

        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.pindrop);

        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final BookModel bookModel = books.get(position);
                if (!bookModel.isRead) {

                    Toast.makeText(getApplicationContext(), "You Read " + bookModel.name, Toast.LENGTH_LONG).show();
                    view.animate().alpha(0.2f);
                    mPlayer.start();
                    bookModel.isRead = true;

                    if(mSharedPreferences != null){
                        mSharedPreferences.edit().putBoolean(bookModel.name, bookModel.isRead).apply();
                    }

                    adapter.notifyDataSetChanged();
                } else {

                    view.animate().alpha(1f);
                    mPlayer.start();
                    bookModel.isRead = false;

                    if(mSharedPreferences != null){
                        mSharedPreferences.edit().putBoolean(bookModel.name, bookModel.isRead).apply();
                    }

                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    /**
     * Creates an ArrayList<BookModel>
     * @return - List<BookModel>
     */
    public List<BookModel> createBooks(){

        final ArrayList<String> topBooks = new ArrayList<String>(Arrays.asList("1984", "To Kill a Mockingbird", "Pride and Prejudice",
                "Harry Potter and the Sorcerer's Stone", "The Great Gatsby", "Jane Eyre", "Wuthering Heights", "The Catcher in the Rye",
                "The Hobbit", "Brave New World", "The Lord of the Rings: The Fellowship of the Ring", "Don Quixote",
                "Catch-22", "The Count of Monte Cristo", "Harry Potter and the Goblet of Fire", "The Grapes of Wrath", "The Adventures of Huckleberry Finn",
                "The Diary of a Young Girl", "Gone with the Wind", "Harry Potter and the Deathly Hallows", "Moby Dick", "Harry Potter and the Half-Blood Prince", "War and Peace",
                "Animal Farm", "Anna Karenina", "Ulysses", "Lord of the Flies", "The Divine Comedy", "One Hundred Years of Solitude", "Frankenstein", "The Perks of Being a Wallflower",
                "The Fault in Our Stars", "Good to Great", "Harry Potter and the Chamber of Secrets", "Harry Potter and the Order of the Phoenix", "Harry Potter and the Prisoner of Azkaban",
                "The Amazing Adventures of Kavalier & Clay", "The Hunger Games", "The Lord of the Rings: The Two Towers", "The Lord of the Rings: The Return of the King", "The Maze Runner",
                "Looking for Alaska", "Fahrenheit 451", "Hamlet", "Gullivers Travels", "The Canterbury Tales", "Rebecca", "The Brothers Karamazov", "Lover Awakened", "At Grave's End"));

        List<BookModel> books = new ArrayList<>(topBooks.size());

        for(int i = 0; i < topBooks.size(); i++){
            BookModel bookModel = new BookModel();
            bookModel.name = topBooks.get(i);

            if(mSharedPreferences != null) {
                // sets the IsRead field from value in preferences
                bookModel.isRead =   mSharedPreferences.getBoolean(bookModel.name, false);
            }else {

                bookModel.isRead = false;

                // Open preferences to write the value in on load
                mSharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

                // Stores the book in shared preferences as un-read
                mSharedPreferences.edit().putBoolean(bookModel.name, false).apply();
            }

            books.add(bookModel);
        }

        return books;
    }
}