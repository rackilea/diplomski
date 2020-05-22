import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {
        try {
            String html = "<!DOCTYPE HTML>" +
                            "<html>" +
                                "<head>" +
                                    "<title>Introduction</title>" +
                                "</head>" +
                                "<body>" +
                                    "<article id=\"mobi_content\">" +
                                        "<h1 class=\"mobi-page-title\">Introduction</h1>" +
                                        "<section id=\"dataSectionInstanceId-431331\" class=\"body-text\">This <i>book</i> is about creating a great career. <p>You might be saying to yourself, \"I don't want to talk about a career, much less a great career. Right now I just need a job. I need to eat!\" <p>Well, if you're looking, we're going to show you how to get that great job now. That's the first, short-term step. <p>But the day will come when you'll want to do more than just eat. And beyond that day will come another day when you look back at your life and take measure of your entire professional contribution to the world. <p>This book is about today and tomorrow. It's about getting a great job now and enjoying a great career for life. <p>When we say a person has had a great career, what do we mean? That he or she made a lot of money? moved spectacularly up the corporate ladder? became famous or renowned in his or her profession? What about the familiar comment from every movie star on every talk show: \"I can't believe I get paid for doing this!\" Are only a few people entitled to feel that way, but not the rest of us? <p>And what about you? Are you looking forward to a great career? Would you describe your current career as \"great\"? When you get to the end of your productive life, will you be looking back on a mediocre career? a good career? a great career? And how will you know? <p>Furthermore, just how do you create a great career for yourself? <p>As coauthors of this book, we are fascinated by these provocative questions. We have been associated in our work for many years as avid students of what it takes to build a great life and career. And we bring two different sets of experiences to the issue, so occasionally, we will speak to you directly in our own voices. We'll share with you our discoveries and provide tools and insights that will help you find answers for yourself. Whether you're looking for a job or want to make the job you have more meaningful, this book is for you." +
                                        "</section>" +
                                    "</article>" +
                                "</body>" + 
                                "</html>";

            Document doc = Jsoup.parse(html);


            System.out.println(removeTags(doc.body().toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String removeTags(String source) {    
        return source.replaceAll("(?!(</?p>|</?i>|</?b>|<br/?>))(</?.*?>)", " ");
    }
}