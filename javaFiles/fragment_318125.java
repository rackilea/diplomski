// Group of all h-Tags
Elements hTags = doc.select("h1, h2, h3, h4, h5, h6");

// Group of all h1-Tags
Elements h1Tags = hTags.select("h1");
// Group of all h2-Tags
Elements h2Tags = hTags.select("h2");
// ... etc.