import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonFoo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(JsonMethod.ALL, Visibility.ANY);
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    Response response = mapper.readValue(new File("input.json"), Response.class);

    for (Map.Entry<Integer, Result> entry : response.result.entrySet())
    {
      System.out.printf("Entry %1$d: %2$s\n", entry.getKey(), entry.getValue());
    }
  }
}

class Response
{
  ResponseStatus status;
  Map<Integer, Result> result;
}

enum ResponseStatus
{
  OK, NOT_OK
}

class Result
{
  int Id;
  String Conferencce;
  String Description;
  BigInteger Admin;
  String Moderator;
  String Keywords;
  Date StartDate;
  Date EndDate;
  String Type;
  int MaxAtendee;
  int MinAtendee;
  int RegAtendee;
  String DescVoiceVideo;
  String Rating;
  Status Status;
  String ApproveBy;
  Date ApprovedOn;
  String ApprovedReason;
  String AdminPin;
  String UserPin;
  String PricePerMin;
  String PricePerConf;
  String ReminderStart;
  String AdminJoin;
  Date CreatedOn;
  int CreatedBy;

  @Override
  public String toString()
  {
    return String.format("Id: %1$d, Conferencce: %2$s, Description: %3$s, Admin: %4$d, StartDate: %5$tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS", Id, Conferencce, Description, Admin, StartDate);
  }
}

enum Status
{
  active, inactive
}