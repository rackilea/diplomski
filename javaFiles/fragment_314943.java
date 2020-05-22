Color kleur;  // <--- here declaring it

    switch (appel){
    case "Gifgroen":
        kleur = new Color(184, 208, 68); // ere initializing it if needed
        break;
    case "Rood":
        kleur = new Color(142, 41, 13);
        break;
    // other cases 
    default:
        kleur = new Color(142, 41, 13);
        break;
}