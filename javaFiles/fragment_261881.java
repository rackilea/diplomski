// META_KEY values, in the order that the columns should be. This should be a
// private static final outside of in the class, along with the query's text...
String[] keys = { "mepr_full_name", "mepr_address", "mepr_city", "mepr_state",
                  "mepr_zip_code", "mepr_home_phone_with_area_code",
                  "mepr_drivers_license_or_id", "mepr_id_state",
                  "mepr_LAst_four_of_social_security_number", "mepr_date_of_birth_mmddyyyy",
                  "mepr_sex_mf", "mepr_height", "mepr_weight" };

// Running thru the ResultSet
short index = 1;
while ( rs.next() )
{
   XSSFRow row = sheet.createRow( index );
   String key = rs.getString(4); // meta_key
   String value = rs.getString( 5 ); // meta_value
   for ( short i = 0; i < keys.length; ++i )
   {
      if ( keys[i].equals( key)) 
      {
         // Retrieving cell, creating if not exists
         XSSFCell cell = row.getCell( i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
         // if the cell is used, increment index o get to the next row
         if ( cell.getCellTypeEnum() != CellType.BLANK )
            ++index;
         // Set the value
         cell.setCellValue( value );
         // No need to walk thru the rest of the array...
         break;
      }
   }
}