int statusCode = response.getStatusLine().getStatusCode();
          if (statusCode == 200) {
              // Server response
              responseString = EntityUtils.toString(r_entity);
          } else {
              responseString = "Error occurred! Http Status Code: "
                      + statusCode;
          }           } catch (ClientProtocolException e) {
          responseString = e.toString();          } catch (IOException e) {
          responseString = e.toString();          }           return responseString;