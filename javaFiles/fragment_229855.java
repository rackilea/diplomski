final String[][] Menu_Item_Data = {
            { "New File", "Open   File", "Close", "Close ALl", "Save", "SaveAs...", "Print" },
            { "Undo Typing", "Redo", "Cut", "Copy", "Paste", "Delete", "Select All" },
            { "Text Color", "Font", "Text Size", "Background Color" }, { "Search..." },
            { "Spaces count", "Words Count", "Sentences Count" } };

for(int i = 0; i < Menu_Item_Data.length; ++i)
        {
            for(int j = 0; j < Menu_Item_Data[i].length; ++j)
            {
                System.out.println("["+ i +"][" + j +"] " + Menu_Item_Data[i][j]);
            }
        }
Output:
[0][0] New File
[0][1] Open   File
[0][2] Close
[0][3] Close ALl
[0][4] Save
[0][5] SaveAs...
[0][6] Print
[1][0] Undo Typing
[1][1] Redo
[1][2] Cut
[1][3] Copy
[1][4] Paste
[1][5] Delete
[1][6] Select All
[2][0] Text Color
[2][1] Font
[2][2] Text Size
[2][3] Background Color
[3][0] Search...
[4][0] Spaces count
[4][1] Words Count
[4][2] Sentences Count