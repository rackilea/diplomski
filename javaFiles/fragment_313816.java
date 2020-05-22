import com.crystaldecisions.reports.common.CrystalResourcesFactory;
import com.crystaldecisions.reports.common.value.FormulaValue;
import com.crystaldecisions.reports.common.value.FormulaValueType;

import com.crystaldecisions.reports.common.value.StringValue;
import com.crystaldecisions.reports.formulas.FormulaFunction;
import com.crystaldecisions.reports.formulas.FormulaFunctionArgumentDefinition;
import com.crystaldecisions.reports.formulas.FormulaFunctionCallException;
import com.crystaldecisions.reports.formulas.FormulaValueReference;
import com.crystaldecisions.reports.formulas.SimpleFormulaFunctionArgumentDefinition;

public abstract class CodeEAN13Base
   implements FormulaFunction
 {
   FormulaFunctionArgumentDefinition[] myArguments = { SimpleFormulaFunctionArgumentDefinition.string,SimpleFormulaFunctionArgumentDefinition.string };

protected CrystalResourcesFactory resCrystal;



  public CodeEAN13Base()
   {
     this.resCrystal = new CrystalResourcesFactory("Messages");

   }


  protected final String doTranslation(String inputData,String opz)
 // protected final String doTranslation(String inputData)
   {
    String returnVal = "";

   //  returnVal = returnVal + translateCharWrapper(inputData);
     returnVal = returnVal + translateCharWrapper(inputData,opz);


    return returnVal;
   }



   @Override
   public final FormulaValue evaluate(FormulaValueReference[] arguments)
     throws FormulaFunctionCallException
  {

       StringValue dataStringArg = (StringValue)arguments[0].getFormulaValue();
       StringValue opzArg =(StringValue)arguments[1].getFormulaValue();

     String dataString = dataStringArg.getString();
     String opz=opzArg.getString();





    String returnVal = doTranslation(dataString,opz);

    return StringValue.fromString(returnVal);
   }

   @Override
   public final FormulaFunctionArgumentDefinition[] getArguments()
  {
     return this.myArguments;
  }

 @Override  
public final FormulaValueType getReturnType()
  {
     return FormulaValueType.string;
   }


   protected abstract String translate(String inputData,String opz)
   throws InvalidBarcodeDataException;

//protected abstract String translate(String inputData)
//throws InvalidBarcodeDataException;

 // private String translateCharWrapper(String inputData)
   private String translateCharWrapper(String inputData,String opz)
  {
     String returnString;

     try
    {
        // returnString = translate(inputData);
      returnString = translate(inputData,opz);
     } catch (InvalidBarcodeDataException e) {
      returnString = "";
     }

    return returnString;
  }



   @Override
   public void validateArgumentValues(FormulaValueReference[] arguments)
     throws FormulaFunctionCallException
   {}
 }

public class CodeEAN13
  extends CodeEAN13Base
{

    //protected String opz;



   @Override
   public String getIdentifier()
   {
    return "barcodeean13";
  }



  private static String oddBar(String code) {

        return String.valueOf((char)(65+Integer.parseInt(code)));

    }

  private static String evenBar(String code) {

        return String.valueOf((char)(75+Integer.parseInt(code)));

    }


@Override

    protected String translate(String inputData, String opz) throws InvalidBarcodeDataException {   

     Integer checkDigitSubtotal;
     String checkDigit;
      String temp = null;
      String code=inputData;
      String azalea_EAN13 = null;
      String opzM=opz;


//    if(!opzM.equals(null)) {
//     code=code+opzM;
//    }

      //Calculate the EAN-13 check digit.

      checkDigitSubtotal=3*(Integer.parseInt(code.substring(1, 2))+Integer.parseInt(code.substring(3, 4))+Integer.parseInt(code.substring(5, 6))
                           +Integer.parseInt(code.substring(7, 8))+Integer.parseInt(code.substring(9, 10))
                           +Integer.parseInt(code.substring(code.length()-1)));


      checkDigitSubtotal=checkDigitSubtotal+(Integer.parseInt(code.substring(0,1))+Integer.parseInt(code.substring(2, 3))
                                       +Integer.parseInt(code.substring(4, 5))+Integer.parseInt(code.substring(6, 7))
                                       +Integer.parseInt(code.substring(8, 9))+Integer.parseInt(code.substring(10, 11)));

  checkDigit=String.valueOf(300-checkDigitSubtotal);
  checkDigit=checkDigit.substring(checkDigit.length()-1);



 // Begin building the output string with the 1st character's human-readable, L guard bars & odd parity of 1st digit
   temp=(char)(194+Integer.parseInt(code.substring(0,1)))+"x"+oddBar(code.substring(1, 2));  

  // Build the remainder of left half of symbol's parity is based on 1st digit
   switch (code.substring(0,1)) {
   case "0":
      {
         //temp="U|x"; 
         temp=temp+oddBar(code.substring(2, 3));
         temp=temp+oddBar(code.substring(3, 4));
         temp=temp+oddBar(code.substring(4, 5));
         temp=temp+oddBar(code.substring(5, 6));
         temp=temp+oddBar(code.substring(6, 7));         
      }
    break;
   case "1":
      {
          //temp="[|x";
          temp=temp+oddBar(code.substring(2, 3)); 
          temp=temp+evenBar(code.substring(3, 4));
          temp=temp+oddBar(code.substring(4, 5));
          temp=temp+evenBar(code.substring(5, 6));
          temp=temp+evenBar(code.substring(6, 7));
      }
      break;
   case "2":
   {
       //temp="V|x";
       temp=temp+oddBar(code.substring(2, 3));
       temp=temp+evenBar(code.substring(3, 4));
       temp=temp+evenBar(code.substring(4, 5));
       temp=temp+oddBar(code.substring(5, 6));
       temp=temp+evenBar(code.substring(6, 7));
   }
   break;
   case "3":
   {
       //temp="W|x";
       temp=temp+oddBar(code.substring(2, 3));
       temp=temp+evenBar(code.substring(3, 4));
       temp=temp+evenBar(code.substring(4, 5));
       temp=temp+evenBar(code.substring(5, 6));
       temp=temp+oddBar(code.substring(6, 7));
   }
    break;
   case "4":
   {
       //temp="X|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+oddBar(code.substring(3, 4));
       temp=temp+oddBar(code.substring(4, 5));
       temp=temp+evenBar(code.substring(5, 6));
       temp=temp+evenBar(code.substring(6, 7));

   }
   break;
   case "5":
   {
       //temp="Y|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+evenBar(code.substring(3, 4));
       temp=temp+oddBar(code.substring(4, 5));
       temp=temp+oddBar(code.substring(5, 6));
       temp=temp+evenBar(code.substring(6, 7));

   }
   break;
   case "6":
   {
       //temp="Z|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+evenBar(code.substring(3, 4));
       temp=temp+evenBar(code.substring(4, 5));
       temp=temp+oddBar(code.substring(5, 6));
       temp=temp+oddBar(code.substring(6, 7));

   }
   break;
   case "7":
   {
       //temp="u|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+oddBar(code.substring(3, 4));
       temp=temp+evenBar(code.substring(4, 5));
       temp=temp+oddBar(code.substring(5, 6));
       temp=temp+evenBar(code.substring(6, 7));



   }
   break;
   case "8":
   {
       //temp="\\|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+oddBar(code.substring(3, 4));
       temp=temp+evenBar(code.substring(4, 5));
       temp=temp+evenBar(code.substring(5, 6));
       temp=temp+oddBar(code.substring(6, 7));

   }
   break;
   case "9":
   {
       //temp="]|x";
       temp=temp+evenBar(code.substring(2, 3));
       temp=temp+evenBar(code.substring(3, 4));
       temp=temp+oddBar(code.substring(4, 5));
       temp=temp+evenBar(code.substring(5, 6));
       temp=temp+oddBar(code.substring(6, 7));

   }
   break;

    default:
   }

////Add the center guard bars & the build right half of symbol using set C (0-9)


    return azalea_EAN13+opzM;
   }




 }