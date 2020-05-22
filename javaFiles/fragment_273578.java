private void setAdapters() {
        todosAdapter = new TodosAdapter(toDoList);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        rvTodos.setLayoutManager(mLayoutManager1);
        rvTodos.setItemAnimator(new DefaultItemAnimator());
        rvTodos.setAdapter(todosAdapter);

        prepareToDOData();//call here
    }


 private void prepareToDOData() {
        ToDo data = new ToDo("David Cummings", "26/10/2017 2:25PM");
        toDoList.add(data);

        data = new ToDo("Lawrence Cummings", "26/10/2017 2:25PM");
        toDoList.add(data);


        data = new ToDo("Ketul Inc.", "11/11/2017 3:46 PM");
        toDoList.add(data);

        //notesAdapter.notifyDataSetChanged();
        todosAdapter.notifyDataSetChanged();
    }