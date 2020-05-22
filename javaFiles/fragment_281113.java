Pass the person array list also in the constructor of the recycler view

    //like in activity
    RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames,personNames);

    //in adapter class
    create a list for person also
    private List<String> mData;
    private List<String> mpersonData;

    // adapter constructor
    MyRecyclerViewAdapter(Context context, List<String> data,List<String> mpersonData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    this.mpersonData = mpersonData;
    }

    //onbind view holder

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        String person = mData.get(position);
        holder.myTextView.setText(animal);
    holder.myTextView.setText(person);
    }

    //change the tv id name to person
      ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            // just change this to person name
            myTextView2 = itemView.findViewById(R.id.tvPersonalName);
            itemView.setOnClickListener(this);
        }

    Now you will set person name also in the recycler view text field


Paste this code instead of relative layout use linear layout

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:padding="10dp">

        <TextView
            android:id="@+id/tvAnimalName"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:weight="1"
            android:gravity="start"
            android:layout_marginStart="8dp"
            android:textSize="20sp" />


        <TextView
            android:id="@+id/tvPersonName"
             android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:weight="1"
            android:gravity="end"
            android:layout_marginEnd="8dp"
            android:textSize="20sp" />

    </LinearLayout>

and you can have two columns as mentioned in the question