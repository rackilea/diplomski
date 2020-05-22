public static void componentsInfoToSimulation(String houseDivision, String equipment)
   {
      Element root = doc.getRootElement();

      // Iterate over the houses
      for (Iterator i = root.elementIterator("house"); i.hasNext();)
      {
         Element houseElement = (Element) i.next();

         // Check if the id of one the house elements equals the houseDivision
         String houseId = houseElement.attributeValue("id");
         if (houseId.equals(houseDivision))
         {
            // Iterate over the equipment for the house
            for (Iterator x = houseElement.elementIterator("equipment"); x.hasNext();)
            {
               Element equipmentElement = (Element) x.next();

               // Check if the id of one the equipment elements equals the
               // equipment
               String equipId = equipmentElement.attributeValue("id");
               if (equipId.equals(equipment))
               {
                  // Get all the elemnts and their values
                  int power = Integer.valueOf(equipmentElement.element("power").getTextTrim());
                  int minPower = Integer.valueOf(equipmentElement.element("min_power").getTextTrim());
                  int maxPower = Integer.valueOf(equipmentElement.element("max_power").getTextTrim());
                  float averageUsageHours = Float.valueOf(equipmentElement.element("average_usage_hour").getTextTrim());
                  float averageUsageMins = Float.valueOf(equipmentElement.element("average_usage_minute").getTextTrim());

                  // Update the model
                  pt.ipp.isep.gecad.masgrip.Simulation.getHouseNamesOfComponents().add(equipment);
                  pt.ipp.isep.gecad.masgrip.Simulation.getHousePowerDosComponents().add(power);
                  pt.ipp.isep.gecad.masgrip.Simulation.getHouseMinPowerComponents().add(minPower);
                  pt.ipp.isep.gecad.masgrip.Simulation.getHouseMaxPowerComponents().add(maxPower);
                  pt.ipp.isep.gecad.masgrip.Simulation.getHouseAverageUsageHoursPerDay().add(averageUsageHours);
                  pt.ipp.isep.gecad.masgrip.Simulation.getHouseAverageUsageMinutesPerDay().add(averageUsageMins);
               }
            }
         }
      }
   }