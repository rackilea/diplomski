public static void main(String[] args) throws Exception {
    ItemType item = new ItemType();

    GuidType guid = new GuidType();
    guid.setIsPermaLink("true");
    guid.setText("http://zuma.livejournal.com/147000.html");    
    item.setGuid(guid);
    item.setPubDate("Sun, 07 Oct 2012 06:43:24 GMT");
    item.setTitle("tao machine");
    item.setLink("http://zuma.livejournal.com/147000.html");
    item.setDescription(">&lt;div class=&quot;qpp3&quot;&gt;&lt;div class=&quot;qpp4&quot;&gt;&lt;div class=&quot;qrbrdr1&quot;&gt;&lt;div class=&quot;qrbrdr2&quot;&gt;&lt;center&gt;&lt;img src=&quot;http://zuma.vip.warped.com/transparent_8x8.png&quot;&gt;&lt;br&gt;&lt;a title=&quot;http://stonedmotors.blogspot.com/2012/10/tao-machine.html&quot; href=&quot;http://stonedmotors.blogspot.com/2012/10/tao-machine.html&quot;&gt;&lt;img src=&quot;http://zuma.vip.warped.com/stonedmotors2.png&quot; border=&quot;0&quot;&gt;&lt;/a&gt;&lt;br&gt;&lt;img src=&quot;http://zuma.vip.warped.com/transparent_8x8.png&quot;&gt;&lt;/center&gt;&lt;/div&gt;&lt;/div&gt;&lt;img src=&quot;http://zuma.vip.warped.com/transparent_8x8.png&quot;&gt;&lt;br&gt;&lt;div class=&quot;a720&quot;&gt;&lt;div class=&quot;b720&quot;&gt;&lt;span class=&quot;tnr&quot;&gt;midnight&lt;/span&gt;&lt;br /&gt;&lt;i&gt;&quot;dirt-tired, greased &amp; wired, but the job&apos;s done, hey.&quot;&lt;/i&gt;&lt;br /&gt;&lt;br /&gt;the scattered tools upon the table, all in disarray. the wrenches, sockets, screwdrivers, extensions &amp; adaptors, nuts &amp; bolts &amp; washers scrounged from the floor and about all (mostly) gathered in coffee cans... the piles of parts; case halves, studs, con rods &amp; cranks, camshafts &amp; shims, heads, manifolds, oil radiators, fan housings, distributors, coils, voltage regulators, generators &amp; alternators, carbs &amp; pistons, fuel pumps, filters, trannies, CV joints, axles, brake shoes, fuses, spark plugs, batteries, mufflers, belts, pulleys, flywheels... the cans of mineral spirits, carb cleaner, oil &amp; gas; brake fluid... cleaning a set of wheel bearings w/ an air hose sets it spinning at umpteen hundred RPM. buckets of grease. pressure plates &amp; throw-out bearings. clamps &amp; hoses. breaker bars &amp; torgue wrenches. plastigauge. pedal clusters. cables. shifter plates &amp; bushings. tires, wheels, brake drums clanging, struck by a 5 pound sledge hammer. smoke from the ashtray curls up to the rafters. the coffee pot ticks. we laugh like mad children w/ dirt (like black soot) on our faces &amp; elbows &amp; old worn clothing in the midnight garage.&lt;/div&gt;&lt;/div&gt;&lt;img src=&quot;http://zuma.vip.warped.com/transparent_8x8.png&quot;&gt;&lt;div class=&quot;zim&quot;&gt;&lt;div class=&quot;im1&quot;&gt;&lt;div class=&quot;im2&quot;&gt;&lt;a title=&quot;960x640 version&quot; href=&quot;http://zuma.vip.warped.com/stomo8.png&quot;&gt;&lt;img src=&quot;http://zuma.vip.warped.com/stomo8_716x476.png&quot; border=&quot;0&quot;&gt;&lt;/a&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;&lt;img src=&quot;http://zuma.vip.warped.com/transparent_8x8.png&quot;&gt;&lt;div class=&quot;a720&quot;&gt;&lt;div class=&quot;b720&quot;&gt;the eternal engine that moves us. forward.&lt;br /&gt;&lt;br /&gt;&lt;i&gt;&quot;i could carve one from a rock...&quot;&lt;/i&gt;&lt;br /&gt;&lt;br /&gt;crank it over. snick it in gear. let out the clutch. foot on the gas in Wide Open Throttle.&lt;br /&gt;&lt;br /&gt;stand on it.&lt;br /&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;");
    item.setComments("http://zuma.livejournal.com/147000.html");
    item.setSecurity("public");
    item.setReplyCount("8");
    item.setCategory(new ArrayList<String>());

    Serializer serializer = new Persister();
    File result = new File("rss.xml");

    serializer.write(item, result);
}