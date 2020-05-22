rule "New Assistance"
when
    $room:Room($tags : tags contains "protocol")
then
    System.out.println("Error");
end