@Override
protected void onCreate(Bundle savedInstanceState)
{
    [...]
    savebutton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            [...]
            try
            {
                PdfStamper stamper=new PdfStamper(reader,output);
                AcroFields acroFields=stamper.getAcroFields();
                acroFields.setField("fullnameorinitials",one);
                acroFields.setField("agedob",two);
            }
            [...]
        }
    });
}