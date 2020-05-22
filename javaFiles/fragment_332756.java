252    } catch (NoSuchAlgorithmException nsae) {
253         throw new InvalidSshKeySignatureException();
254    } catch (InvalidKeyException ike) {
255        throw new InvalidSshKeySignatureException();
256    } catch (IOException ioe) {
257        throw new InvalidSshKeySignatureException();
258    } catch (SignatureException se) {
259        throw new InvalidSshKeySignatureException();
260    }