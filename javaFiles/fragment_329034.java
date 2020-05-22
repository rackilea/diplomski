if(DATABASE_VERSION == 1)
    {


        try {

            copyDataBaseForVersion1();
            DATABASE_VERSION = 3;

        } catch (IOException e) {

            throw new Error("Error copying database");

        }

    }
else if(DATABASE_VERSION == 2)
    {


        try {

            copyDataBaseForVersion2();
            DATABASE_VERSION = 3;

        } catch (IOException e) {

            throw new Error("Error copying database");

        }

    }