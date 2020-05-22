public class YourViewModel extends ViewModel {

    // Create a LiveData with a List of Contact
    private MutableLiveData<List<Contact>> contactList = new MutableLiveData<>();

    // encapsulated with immutable live data
    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }

    // call this method with a list of new contacts whenever you need to refresh your list
    public void updateContactList(List<Contact> list) {
        contactList.setValue(list);
    }

    // Rest of the ViewModel...
}