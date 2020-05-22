if(request.getParameter("anmeldenbutton")!=null)
    {
        HttpSession session = request.getSession(true);

        String spielerNickname = request.getParameter("spielerAnmeldungTextFeld");
        boolean spielerKannErzeugtWerden = SpielerKontroller.addSpielerNicknameZuKontroller(spielerNickname);
        Spieler neuerSpieler;
        if(spielerKannErzeugtWerden)
        {   
            neuerSpieler = new Spieler(spielerNickname);
            SpielerKontroller.addSpielerZuKontroller(neuerSpieler);
            session.setAttribute("angemeldeterspieler", neuerSpieler);
            session.setAttribute("gegnerliste", SpielerKontroller.getGegnerListe(neuerSpieler));

            request.getRequestDispatcher("/angemeldeterspieler.jsp").forward(request, response);
        }