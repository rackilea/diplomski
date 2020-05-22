for(Marker m : list) {
    if(m.getSnippet().equals(yourSnippet)) {
        // move google map to focus on  marker
        break; // stop the loop
    }
}