StringBuilder sb = new StringBuilder(64);
for (i = 0; i < indices.length; i++) {
    if (sb.length() > 0) {
        sb.append(", ");
    }
    sb.append(countries[indices[i]]);
}        
countryLabel.setText(sb.toString());