String imageRegex = "(<img)(.*?)(/>)";
        String str = "<img src=\"static/image/smiley/comcom/9.gif\" smilieid=\"296\" border=\"0\" alt=\"\" />hello world<img src=\"static/image/smiley/comcom/7.gif\" smilieid=\"294\" border=\"0\" alt=\"\" />";
        System.Text.RegularExpressions.MatchCollection match = System.Text.RegularExpressions.Regex.Matches(str, imageRegex, System.Text.RegularExpressions.RegexOptions.IgnoreCase);
        StringBuilder sb = new StringBuilder();
        foreach (System.Text.RegularExpressions.Match m in match)
        {
            sb.AppendLine(m.Value);
        }
        System.Windows.MessageBox.Show(sb.ToString());