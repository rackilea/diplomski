// ************************************************************************************************
// XPath

/**
* Gets an XPath for an element which describes its hierarchical location.
*/
this.getElementXPath = function(element)
{
if (element && element.id)
return '//*[@id="' + element.id + '"]';
else
return this.getElementTreeXPath(element);
};

this.getElementTreeXPath = function(element)
{
var paths = [];

// Use nodeName (instead of localName) so namespace prefix is included (if any).
for (; element && element.nodeType == 1; element = element.parentNode)
{
var index = 0;
for (var sibling = element.previousSibling; sibling; sibling = sibling.previousSibling)
{
// Ignore document type declaration.
if (sibling.nodeType == Node.DOCUMENT_TYPE_NODE)
continue;

if (sibling.nodeName == element.nodeName)
++index;
}

var tagName = element.nodeName.toLowerCase();
var pathIndex = (index ? "[" + (index+1) + "]" : "");
paths.splice(0, 0, tagName + pathIndex);
}

return paths.length ? "/" + paths.join("/") : null;
};

this.getElementCSSPath = function(element)
{
var paths = [];

for (; element && element.nodeType == 1; element = element.parentNode)
{
var selector = this.getElementCSSSelector(element);
paths.splice(0, 0, selector);
}

return paths.length ? paths.join(" ") : null;
};

this.cssToXPath = function(rule)
{
var regElement = /^([#.]?)([a-z0-9\\*_-]*)((\|)([a-z0-9\\*_-]*))?/i;
var regAttr1 = /^\[([^\]]*)\]/i;
var regAttr2 = /^\[\s*([^~=\s]+)\s*(~?=)\s*"([^"]+)"\s*\]/i;
var regPseudo = /^:([a-z_-])+/i;
var regCombinator = /^(\s*[>+\s])?/i;
var regComma = /^\s*,/i;

var index = 1;
var parts = ["//", "*"];
var lastRule = null;

while (rule.length && rule != lastRule)
{
lastRule = rule;

// Trim leading whitespace
rule = this.trim(rule);
if (!rule.length)
break;

// Match the element identifier
var m = regElement.exec(rule);
if (m)
{
if (!m[1])
{
// XXXjoe Namespace ignored for now
if (m[5])
parts[index] = m[5];
else
parts[index] = m[2];
}
else if (m[1] == '#')
parts.push("[@id='" + m[2] + "']");
else if (m[1] == '.')
parts.push("[contains(concat(' ',normalize-space(@class),' '), ' " + m[2] + " ')]");

rule = rule.substr(m[0].length);
}

// Match attribute selectors
m = regAttr2.exec(rule);
if (m)
{
if (m[2] == "~=")
parts.push("[contains(@" + m[1] + ", '" + m[3] + "')]");
else
parts.push("[@" + m[1] + "='" + m[3] + "']");

rule = rule.substr(m[0].length);
}
else
{
m = regAttr1.exec(rule);
if (m)
{
parts.push("[@" + m[1] + "]");
rule = rule.substr(m[0].length);
}
}

// Skip over pseudo-classes and pseudo-elements, which are of no use to us
m = regPseudo.exec(rule);
while (m)
{
rule = rule.substr(m[0].length);
m = regPseudo.exec(rule);
}

// Match combinators
m = regCombinator.exec(rule);
if (m && m[0].length)
{
if (m[0].indexOf(">") != -1)
parts.push("/");
else if (m[0].indexOf("+") != -1)
parts.push("/following-sibling::");
else
parts.push("//");

index = parts.length;
parts.push("*");
rule = rule.substr(m[0].length);
}

m = regComma.exec(rule);
if (m)
{
parts.push(" | ", "//", "*");
index = parts.length-1;
rule = rule.substr(m[0].length);
}
}

var xpath = parts.join("");
return xpath;
};