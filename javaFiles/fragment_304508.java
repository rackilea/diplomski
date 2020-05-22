case 9154: // Logout Button
    if (loggedIn) {
        loggedIn = false;
        c.logout();
    }
    break;