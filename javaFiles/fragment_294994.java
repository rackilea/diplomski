out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(canDataInfo);

        out.close();
    }
    catch (Exception ex)