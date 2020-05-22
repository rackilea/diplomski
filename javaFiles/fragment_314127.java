HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
connection.setRequestMethod("HEAD");
int responseCode = connection.getResponseCode();
if (responseCode != 200) {
    // Not OK.
}

// < 100 is undetermined.
// 1nn is informal (shouldn't happen on a GET/HEAD)
// 2nn is success
// 3nn is redirect
// 4nn is client error
// 5nn is server error