Model extends Observable {  //various observers can be notified when property changes.
    setValueForA(Object value) {...
      setChanged();
      notifyObservers(value);
    }
    //Example setter above. Similar code needed in all required properties.
}