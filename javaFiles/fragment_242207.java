public void initialize() {

    // existing code...

    Stream.of(listView1, listView2, listView3)
          .forEach(this::configureListViewDragAndDrop);

}