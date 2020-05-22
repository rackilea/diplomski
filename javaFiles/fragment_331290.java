COAUTHIDENTITY auth = new COAUTHIDENTITY();

String user = "username"; // or get from the user
// Allocate memory for user including null terminator
auth.User = new Memory(Native.WCHAR_SIZE * (user.length() + 1));
// Set the widestring in memory
auth.User.setWideString(0, user);
auth.UserLength = user.length();

// Do the same for domain and password

auth.Flags = SEC_WINNT_AUTH_IDENTITY_ANSI;
// Note: SEC_WINNT_AUTH_IDENTITY_ANSI = 1