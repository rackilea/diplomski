int i = 0;
        while (classLoader == null)
        {
            try
            {
                if (classLoader == null)
                {
                    dynamicClass = pool.get("org.yaddayadda.DynamicClass");
                    dynamicClass.defrost();


                    try
                    {
                        dynamicSurrugate = pool.get("org.yaddayadda.DynamicClass" + genericType.getName().toLowerCase() + uniqueID);

                        dynamicSurrugate.defrost();
                    }
                    catch (NotFoundException notFoundException)
                    {
                    }


                    //Everything the same
                }
            }
            catch (Exception exception)
            {
                classLoader = null;
                i++;
            }

            if (i == 3)
            {
                throw new Exception("IF failed throw message third time");
            }
        }