String[] tests = { 
        "MAC Address=192.167.235.19",
        "MAC Address=192.167.235.19; zproduct_id=XYZ",
        "MAC Address=192.167.235.19; ",
        "MAC =Address=192.167.235.19; zproduct_id=XYZ",
};

for (String s : tests)
    System.out.println(s + " -> " + s.matches("([^=;]+=[^=;]+(;|$))+"));