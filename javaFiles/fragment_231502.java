@NoTitle
@Fullscreen
@EActivity(R.layout.bookmarks)
public class BookmarksToClipboardActivity extends Activity {

  BookmarkAdapter adapter;

  @ViewById
  ListView bookmarkList;

  @ViewById
  EditText search;

  @App
  BookmarkApplication application;

  @RestService
  BookmarkClient restClient;

  @AnimationRes
  Animation fadeIn;

  @SystemService
  ClipboardManager clipboardManager;

  @AfterViews
  void initBookmarkList() {
    adapter = new BookmarkAdapter(this);
    bookmarkList.setAdapter(adapter);
  }

  @Click({R.id.updateBookmarksButton1, R.id.updateBookmarksButton2})
  void updateBookmarksClicked() {
    searchAsync(search.getText().toString(), application.getUserId());
  }

  @Background
  void searchAsync(String searchString, String userId) {
    Bookmarks bookmarks = restClient.getBookmarks(searchString, userId);
    updateBookmarks(bookmarks);
  }

  @UiThread
  void updateBookmarks(Bookmarks bookmarks) {
    adapter.updateBookmarks(bookmarks);
    bookmarkList.startAnimation(fadeIn);
  }

  @ItemClick
  void bookmarkListItemClicked(Bookmark selectedBookmark) {
    clipboardManager.setText(selectedBookmark.getUrl());
  }

}