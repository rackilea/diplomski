// Suppose, below are the actual views
String actualViewsString = "Ali, Reporting Period, Business Day, Managed Geography, Business Organization, Relationship Managed Industry, Accounting Treatment, Business Unit, Managed Segment, Booking Country, Sector, Third Party / Intercompany, Show Adjustments, Approving Unit, Legal Vehicle, Legal Vehicle Country, Asset Type, Coverage, IRU Credit Org, IRU Credit Coverage, IRU Region, Senior Risk Manager, CAGID";
String[] actualViews = actualViewsString.split(", ");
for(String actualView : actualViews) {
    System.out.println(actualView);
}

System.out.println("****************************************************************");

// Suppose, below are the xviews
String xviewsString = "Reporting Period, Business Day, Managed Geography, Business Organization, Relationship Managed Industry, Accounting Treatment, Business Unit, Managed Segment, Booking Country, Sector, Third Party / Intercompany, Show Adjustments, Approving Unit, Legal Vehicle, Legal Vehicle Country, Asset Type, Coverage, IRU Credit Org, IRU Credit Coverage, IRU Region, Senior Risk Manager, CAGID";
String[] xviews = xviewsString.split(", ");
for(String xview : xviews) {
    System.out.println(xview);
}

// Comparing both the String arrays
for(int i=0;i<actualViews.length;i++) {
    boolean matching = false;
    for(int j=0;j<xviews.length;j++) {
        if(actualViews[i].equals(xviews[j])) {
            matching = true;
            break;
        }
    }
    if(matching) {
        System.out.println("=> '"+actualViews[i]+"' matching is there in the both arrays...");
    } else {
        System.out.println("\n===> '"+actualViews[i]+"' matching is NOT there in the both arrays...\n");
    }
}