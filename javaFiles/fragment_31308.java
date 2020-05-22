mainTable.addCell(PDFUtil.getBlankLine(20f));
  float[] colsWidth = {0.5f,3.8f,0.9f,0.9f,1.3f,0.9f,1.3f,1.4f}; 
  PdfPTable itemListTab = new PdfPTable(colsWidth);

  PdfPCell slNo = PDFUtil.getTableHeaderCell(PDFUtil.S_NO,
        PDFUtil.getBoldFont());

  PdfPCell itmDesc = PDFUtil.getTableHeaderCell(PDFUtil.ITEM_DESC,
        PDFUtil.getBoldFont());

  PdfPCell loose = PDFUtil.getTableHeaderCell(PDFUtil.LOOSE_QTY,
        PDFUtil.getBoldFont());
  PdfPCell full = PDFUtil.getTableHeaderCell(PDFUtil.FULL_QTY,
        PDFUtil.getBoldFont());
  PdfPCell unitPrc = PDFUtil.getTableHeaderCell(PDFUtil.QUOTED_PRICE,
        PDFUtil.getBoldFont());

  PdfPCell disc = PDFUtil.getTableHeaderCell(
        PDFUtil.ITM_DISCOUNT_PERCENT, PDFUtil.getBoldFont());
  PdfPCell netAmt = PDFUtil.getTableHeaderCell(PDFUtil.NET_PRICE,
        PDFUtil.getBoldFont());
  PdfPCell amt = PDFUtil.getTableHeaderCell(PDFUtil.AMOUNT_LABEL, PDFUtil
        .getBoldFont());
  amt.setHorizontalAlignment(Element.ALIGN_RIGHT);
  itemListTab.addCell(slNo);

  itemListTab.addCell(itmDesc);

  itemListTab.addCell(full);
  itemListTab.addCell(loose);
  itemListTab.addCell(unitPrc);

  itemListTab.addCell(disc);
  itemListTab.addCell(netAmt);
  itemListTab.addCell(amt);ArrayList aList = vendPOVO.getItemList();
  if (aList != null)
  {
    Object[] iList = aList.toArray();
    Arrays.sort(iList, new ItemSNoComparator(aList));
    int len = iList.length;
    InventoryLogger.logDebug("After sorting the item list by SNo");
    InventoryLogger.logDebug("length"+len);



    int lenthChr = 0;
    int lineLength = 34;
    float maxLineLength = 34;
    for (int j = 0; j < len; j++)
    {
        ItemMasterVO itmMstrVO = (ItemMasterVO) iList[j];
        if (InventoryConstants.TRUE.equals(itmMstrVO.getVendPurOrdInd()))
        {

    String ctry = " ";
    if(itmMstrVO.getCtryOfOrigin() != null)
    {
        ctry =  InventoryUtil.getStaticElementDescription(itmMstrVO.getCtryOfOrigin(),InventoryConstants.STATIC_ELE_CTRY);
    }
    String uomDesc = "";
    String looseUomTemp = "";
    String Space = "";
    if(itmMstrVO.getUomDesc().matches(InventoryConstants.UOM_KGGM) )
    {
        uomDesc = "1 KG ";
        looseUomTemp = "KG";
    }
    else
    {
        uomDesc = itmMstrVO.getUomDesc();
        looseUomTemp = itmMstrVO.getLooseUOM();
    }

    int lenthChrTmp = (itmMstrVO.getItemDesc1() + " / " + itmMstrVO.getItemDesc2() + " / " + uomDesc+ "/" + ctry).length() ;

    lenthChr = (lenthChr > lenthChrTmp)?lenthChr:lenthChrTmp;


        }
    }



    int mod = ((lenthChr % lineLength)> 0)?1:0;
    maxLineLength = ((lenthChr/lineLength) + mod) * 13;

    for (int i = 0; i < len; i++)
    {
        InventoryLogger.logDebug("inside for");
        ItemMasterVO itmMstrVO = (ItemMasterVO) iList[i];
        if (InventoryConstants.TRUE.equals(itmMstrVO
        .getVendPurOrdInd()))
        {
    String ctry = " ";
    InventoryLogger.logDebug("Country of origin"+itmMstrVO.getCtryOfOrigin());
    if(itmMstrVO.getCtryOfOrigin() != null)
    {
        ctry =  InventoryUtil.getStaticElementDescription(
      itmMstrVO.getCtryOfOrigin(),InventoryConstants.STATIC_ELE_CTRY);
    }
    String uomDesc = "";
    String looseUomTemp = "";
    if(itmMstrVO.getUomDesc().matches(InventoryConstants.UOM_KGGM) )
    {
        uomDesc = "1 KG ";
        looseUomTemp = "KG";
    }
    else
    {
        uomDesc = itmMstrVO.getUomDesc();
        looseUomTemp = itmMstrVO.getLooseUOM();
    }
    String flFlagCheck = "";
    InventoryLogger.logDebug("fl"+itmMstrVO.getFullLooseInd());
    if(itmMstrVO.getFullLooseInd().matches(InventoryConstants.FULL_LOOSE_IND_F))
    {
        flFlagCheck = itmMstrVO.getFullUOM();
    }
    else
    {
        flFlagCheck = itmMstrVO.getLooseUOM();
    }

    itemListTab
            .addCell(new PdfPCell(new Phrase(itmMstrVO
        .getCusQuoSerialNo(), PDFUtil
        .getNormalFont())));

    PdfPCell descCell = new  PdfPCell(new Phrase(itmMstrVO
            .getItemDisplayName()+ " / " + uomDesc + "/" + ctry , PDFUtil
            .getNormalFont()));
    descCell.setFixedHeight(maxLineLength);
    itemListTab.addCell(descCell);

    itemListTab.addCell(new PdfPCell(new Phrase(Long
            .toString(itmMstrVO.getQuoFull())+" "+itmMstrVO.getFullUOM(), PDFUtil
            .getNormalFont())));
    PdfPCell cellone = new PdfPCell(new Phrase(Long.toString(itmMstrVO.getQuoLoose())+" "+itmMstrVO.getLooseUOM(), PDFUtil.getNormalFont()));itemListTab.addCell(cellone);itemListTab.addCell(new PdfPCell(new Phrase(InventoryUtil.getTwoDecDigPrecisionMin(itmMstrVO.getDiscUnitPrice())+"/"+flFlagCheck, PDFUtil
            .getNormalFont())));

    itemListTab.addCell(new PdfPCell(new Phrase(InventoryUtil.getTwoDecDigPrecisionMin(itmMstrVO.getDiscPercent()), PDFUtil
            .getNormalFont())));
    itemListTab.addCell(new PdfPCell(new Phrase((InventoryUtil.getTwoDecDigPrecisionMin(itmMstrVO.getDiscUnitPrice()))+"/" +flFlagCheck, PDFUtil.getNormalFont())));
    itemListTab.addCell(new PdfPCell(new Phrase(InventoryUtil.getTwoDecDigPrecisionMin(itmMstrVO.getAmount()), PDFUtil
            .getNormalFont())));
        }
    }
  }
  PdfPCell addCell = new PdfPCell(itemListTab);
  addCell.setBorder(0);
  mainTable.addCell(addCell);