{namespace com.example}

 /**
 * Says hello to a person (or to the world if no person is given).
 * @param title the page title
 * @param body the page body
 */
{template .base}
<html>
<head>
<title>{$title}</title>
</head>
<body>
{$body}
</body>
</html>
{/template}

/**
* Search Result
*/
{template .servlet1}
  {call base}
    {param title}
      Example Title
    {/param}
    {param body}
      Here comes my body!
    {/param}
  {/call}
{/template}