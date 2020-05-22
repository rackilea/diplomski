private String convertOldISOCodes(String language) { 
    // we accept both the old and the new ISO codes for the languages whose ISO 
    // codes have changed, but we always store the OLD code, for backward compatibility 
    language = toLowerCase(language).intern(); 
    if (language == "he") { 
        return "iw"; 
    } else if (language == "yi") { 
        return "ji"; 
    } else if (language == "id") { 
        return "in"; 
    } else { 
        return language; 
    }
}