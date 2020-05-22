ps.execute("DROP FUNCTION IF EXISTS `IMC`");

ps.execute("CREATE FUNCTION `IMC` (altura INT,peso INT)"
           + " RETURNS DOUBLE"
           + " BEGIN"
           + " DECLARE AltM DOUBLE;"
           + " DECLARE AltSqr DOUBLE;"
           + " SET AltM=(altura/100);"
           + " SET AltSqr=AltM*AltM;"
           + " RETURN peso/AltSqr;");